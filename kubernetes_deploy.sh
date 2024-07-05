#!/bin/bash

kubectl apply -f kubernetes/namespace/nba-stats-tracker-namespace.yaml
kubectl apply -f kubernetes/configmap/nba-stats-tracker-configmap.yaml
kubectl apply -f kubernetes/secrets/nba-stats-tracker-secrets.yaml
kubectl apply -f kubernetes/deployments/nba-stats-tracker-service-discovery.yaml
kubectl apply -f kubernetes/deployments/nba-stats-tracker-web-server.yaml
kubectl apply -f kubernetes/deployments/nba-stats-tracker-api-gateway.yaml
kubectl apply -f kubernetes/deployments/nba-stats-tracker-redis.yaml
