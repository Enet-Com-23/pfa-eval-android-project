#!/bin/bash

# fail if any commands fails
set -e
# debug log
# set -x
# VARIABLES
#API_LEVEL=29
ANDROID_HOME_SDK="/usr/local/lib/android/sdk"
CMD_PATH="/cmdline-tools/latest"
TOOLS_PATH=$ANDROID_HOME_SDK$CMD_PATH

start_emulator() {
}

# Check Emulator already Installed
EMULATOR_COUNT=$("$ANDROID_HOME_SDK"/emulator/emulator -list-avds | wc -l)

if [[ "$EMULATOR_COUNT" -gt 0 ]]; then
    echo "Emulator already available"
    start_emulator
else
    # Install Emulator
    $TOOLS_PATH/bin/sdkmanager --update
    $TOOLS_PATH/bin/sdkmanager --install "emulator"
    $TOOLS_PATH/bin/sdkmanager --install "system-images;android-${IMG_API_LEVEL};google_apis;x86"
    $ANDROID_HOME_SDK/emulator/emulator -list-avds
    # #echo "no" | ${ANDROID_HOME_SDK}/tools/bin/avdmanager --verbose create avd --force --name "test" --device "pixel" --package "system-images;android-${API_LEVEL};google_apis;x86" --tag "google_apis" --abi "x86"
    start_emulator
fi

# LINUX:
# $ANDROID_HOME: /usr/local/lib/android/sdk
# MAC:
# $ANDROID_HOME: /Users/runner/Library/Android/sdk
