#!/bin/bash

# 服务名称及对应端口
declare -A SERVICES=(
  ["CheckoutServer"]=50050
  ["InventoryServer"]=50052
  ["RecommendationServer"]=50051
  ["OrchestratorServer"]=50053
  ["SmartRetailGuiApplication"]=8080
)

echo "🛑 Stopping Smart Retail services..."

for SERVICE in "${!SERVICES[@]}"; do
  PORT=${SERVICES[$SERVICE]}
  PID=$(lsof -ti tcp:$PORT)
  
  if [[ -n "$PID" ]]; then
    echo "🔻 Stopping $SERVICE (PID: $PID) on port $PORT"
    kill -9 $PID
  else
    echo "✅ $SERVICE is not running (port $PORT)"
  fi
done

# 杀掉OrchestratorClient，如果有
echo "🔍 Checking OrchestratorClient..."
pkill -f 'com.retail.orchestrator.OrchestratorClient'

echo "✅ All stop commands issued."