# ===== Build =====
FROM node:20-alpine AS build
WORKDIR /ui
COPY package*.json ./
RUN npm ci
COPY . .
RUN npm run build

# ===== Serve =====
FROM nginx:stable-alpine
COPY --from=build /ui/dist/shady-rest-ui/browser /usr/share/nginx/html
EXPOSE 80
CMD ["nginx","-g","daemon off;"]
