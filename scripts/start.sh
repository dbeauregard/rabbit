#!/bin/bash

if [[ $# -ne 1 && $# -ne 2 ]]; then
    echo "Usage: $0 <Server Number> [-detached]"
    exit 1
fi

if [[ $# -eq 2 ]]; then
    if [[ $2 == "-detached" ]]; then
        echo "Running detached"
    else
        echo "Usage: $0 <Server Number> [-detached]"
        exit 1
    fi
fi

echo "Starting RabbitMQ Server# $1"

export RABBITMQ_CONF_ENV_FILE="/Users/dbeauregard/Workspace/rabbit/scripts/rabbitmq$1-env.conf"
echo "Config File: $RABBITMQ_CONF_ENV_FILE"

/opt/homebrew/opt/rabbitmq/sbin/rabbitmq-server $2