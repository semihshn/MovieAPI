echo "Starting postgres container.."
docker run --name sem-postgres \
  -e POSTGRES_USER=sem-user \
  -e POSTGRES_PASSWORD=sem-password \
  -d \
  -p 5432:5432 \
  postgres

echo "Starting redis container.."
docker run --name sem-redis \
  -d \
  -e ALLOW_EMPTY_PASSWORD=yes \
  -p 6379:6379 \
  bitnami/redis:latest