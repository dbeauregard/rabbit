#!/bin/bash
echo 'cleaning up working dirs'
set -x
rm rabbit1/logs/*
rm rabbit2/logs/*
rm rabbit3/logs/*
rm -r rabbit1/mnesia/*
rm -r rabbit2/mnesia/*
rm -r rabbit3/mnesia/*