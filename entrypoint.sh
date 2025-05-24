#!/bin/bash

echo "Overriding gradlew from /opt..."

# Проверка существования /opt/gradlew
if [ -f /opt/gradlew ]; then
    cp -f /opt/gradlew /home/jenkins/wiki/gradlew
    chmod +x /home/jenkins/wiki/gradlew
    echo "gradlew copied and made executable."
else
    echo "Error: /opt/gradlew not found."
    exit 1
fi

# Проверка доступности рабочей директории
if [ ! -d /home/jenkins/wiki ] || [ ! -w /home/jenkins/wiki ]; then
    echo "Error: /home/jenkins/wiki is not accessible or writable."
    exit 1
fi

exec bash