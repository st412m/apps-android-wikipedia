FROM base-img:1.0.2

LABEL version="0.1.7"

USER root

ENV TZ="Europe/Moscow"
ENV EMULATOR_IMAGE="system-images;android-33;google_apis;x86_64"
ENV ANDROID_HOME_EMULATOR="$ANDROID_HOME/emulator"
ENV ANDROID_SDK_ROOT=$ANDROID_HOME
ENV ADB_SERVER_DIR=/opt/adbserver
# ENV MARATHON=/opt/marathon
ARG ADB_SERVER_JAR=adbserver.jar
ARG ADB_SERVER_URL="https://github.com/KasperskyLab/Kaspresso/raw/master/artifacts/adbserver-desktop.jar"
# ARG MARATHON_VER="0.10.3"
# ARG MARATHON_ZIP="marathon-$MARATHON_VER.zip"
# ARG MARATHON_URL="https://github.com/MarathonLabs/marathon/releases/download/$MARATHON_VER/$MARATHON_ZIP"
# ARG MARATHON_FILE="Marathonfile"
ARG NODE_URL="https://deb.nodesource.com/setup_22.x"

# Установка KVM, эмулятора, ADB-сервера, Node.js и dos2unix
RUN apt-get update && \
    apt-get install -y --no-install-recommends \
    qemu-kvm libvirt-daemon-system libvirt-clients bridge-utils && \
    curl -fsSL $NODE_URL | bash - && \
    apt-get install -y nodejs dos2unix && \
    npm install -g @mockoon/cli && \
    npm cache clean --force && \
    sdkmanager --update && \
    sdkmanager "emulator" && \
    echo "y" | sdkmanager "$EMULATOR_IMAGE" && \
    mkdir -p $ADB_SERVER_DIR && \
    wget -c -O $ADB_SERVER_DIR/$ADB_SERVER_JAR ${ADB_SERVER_URL} && \
    rm -rf /var/lib/apt/lists/* /tmp/* /var/tmp/*
    # mkdir -p $MARATHON && \
    # wget -c -O $MARATHON/$MARATHON_ZIP $MARATHON_URL && \
    # unzip -d $MARATHON $MARATHON/$MARATHON_ZIP && \

# COPY "$MARATHON_FILE" $MARATHON/$MARATHON_FILE

# Установка build-tools и платформы
RUN sdkmanager "build-tools;33.0.2" "platforms;android-33"

# Копируем исправленный gradlew
COPY gradlew /opt/gradlew
RUN dos2unix /opt/gradlew && chmod +x /opt/gradlew

# Копируем entrypoint
COPY entrypoint.sh /entrypoint.sh
RUN chmod +x /entrypoint.sh

# Настройка прав и директорий
RUN groupadd -f libvirt && \
    groupadd -f kvm && \
    if id -u jenkins >/dev/null 2>&1; then \
        usermod -aG libvirt,kvm jenkins; \
    else \
        echo "Error: User 'jenkins' does not exist."; \
        exit 1; \
    fi && \
    mkdir -p /home/jenkins/wiki && \
    chown -R jenkins:jenkins /home/jenkins/wiki
    # chown -R jenkins:jenkins $MARATHON

WORKDIR /home/jenkins/wiki
USER jenkins

ENV PATH="${PATH}:$ANDROID_HOME_EMULATOR"
# ENV PATH="${PATH}:$ANDROID_HOME_EMULATOR:$MARATHON/marathon-$MARATHON_VER/bin"

ENTRYPOINT ["/entrypoint.sh"]
CMD ["bash"]

