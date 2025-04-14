#!/bin/bash

echo "Stopping all Java services..."
pkill -f 'mvn exec:java'