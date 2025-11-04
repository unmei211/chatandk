.PHONY: env clean start soft-clean global-env

env:
	@ENV_FILE=.env; \
	TARGET_FILE=gradle.properties; \
	grep -v '^#' $$ENV_FILE | \
	grep '=' > $$TARGET_FILE; \
	echo "Saved selected envs to $$TARGET_FILE"

start:
	docker compose up -d --build
start-follow:
	docker compose up --build
clean:
	docker compose down -v
soft-clean:
	docker compose down