FROM node:14.20.0-slim AS build
WORKDIR /app
COPY . .
# RUN export NODE_OPTIONS=--openssl-legacy-provider
RUN npm ci && npm run build

# stage 2

FROM nginx:alpine
COPY ./default.conf etc/nginx/conf.d/default.conf
COPY --from=build /app/dist/hw3-frontend /etc/share/nginx/html
EXPOSE 80