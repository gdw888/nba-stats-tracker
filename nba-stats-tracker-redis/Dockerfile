# Use the official Redis image as a base image
FROM redis:latest

# Copy the custom configuration file into the container
COPY redis.conf /usr/local/etc/redis/redis.conf

# Expose the default Redis port
EXPOSE 6379

# Run Redis with the custom configuration file
CMD ["redis-server", "/usr/local/etc/redis/redis.conf"]