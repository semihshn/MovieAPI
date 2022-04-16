echo "Stopping and removing containers.."
docker rm -f \
  sem-postgres \
  sem-redis