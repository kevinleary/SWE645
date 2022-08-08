FROM node:14.20.0-slim
WORKDIR /app
COPY . .
# RUN export NODE_OPTIONS=--openssl-legacy-provider
RUN npm ci && npm run build

EXPOSE 4200
ENTRYPOINT npm run start

# stage 2

# FROM nginx:alpine
# COPY ./default.conf etc/nginx/conf.d/default.conf
# COPY --from=build /app/dist/hw3-frontend /etc/share/nginx/html
# EXPOSE 80