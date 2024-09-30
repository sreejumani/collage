FROM node:20.8 AS build
WORKDIR /app
COPY package.json package-lock.json ./
RUN npm install --force
COPY . .
CMD ["npm", "start", "--","--host","0.0.0.0"]

# FROM node:18 AS build
# WORKDIR /app
# RUN npm install -g @angular/cli 
# COPY package.json package-lock.json ./ 
# RUN npm install
# COPY . .
# RUN ng build
#CMD ["ng", "serve", "--host", "0.0.0.0", "--port", "8080"]
# COPY package.json package-lock.json ./
# RUN npm install
# RUN npm run build --prod
# CMD ["ng", "serve", "--host", "0.0.0.0"]


