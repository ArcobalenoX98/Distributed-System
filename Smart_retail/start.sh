#!/bin/bash

PROJECT_DIR="$PWD"
LOG_DIR="$PROJECT_DIR/logs"
mkdir -p "$LOG_DIR"

get_port() {
  case $1 in
    com.retail.checkout.CheckoutServer) echo 50050 ;;
    com.retail.inventory.InventoryServer) echo 50052 ;;
    com.retail.recommendation.RecommendationServer) echo 50051 ;;
    com.retail.orchestrator.OrchestratorServer) echo 50053 ;;
    com.retail.gui.SmartRetailGuiApplication) echo 8080 ;;
    *) echo "" ;;
  esac
}

run_service() {
  MAIN_CLASS=$1
  PORT=$(get_port "$MAIN_CLASS")
  LOG_FILE="$LOG_DIR/${MAIN_CLASS##*.}.log"

  if [[ -n "$PORT" ]]; then
    if lsof -i :$PORT -sTCP:LISTEN -t >/dev/null; then
      echo "⏭️  $MAIN_CLASS is already running on port $PORT. Skipping..."
      return
    fi
  fi

  echo "🚀 Starting $MAIN_CLASS..."
  osascript <<EOF
tell application "Terminal"
  do script "cd '$PROJECT_DIR'; mvn exec:java -Dexec.mainClass='$MAIN_CLASS' > '$LOG_FILE' 2>&1"
end tell
EOF
}

# 启动所有服务
run_service "com.retail.checkout.CheckoutServer"
run_service "com.retail.inventory.InventoryServer"
run_service "com.retail.recommendation.RecommendationServer"
run_service "com.retail.orchestrator.OrchestratorServer"
run_service "com.retail.orchestrator.OrchestratorClient"
run_service "com.retail.gui.SmartRetailGuiApplication"