# node 이미지를 기반으로
FROM node:16

# 작업 디렉토리를 생성
WORKDIR /app/enhanced-inventory-server

# package.json, yarn.lock을 복사
COPY package.json yarn.lock ./

# 프로젝트 의존성 설치
RUN yarn install
# TypeScript를 글로벌로 설치

RUN yarn global add typescript ts-node

# 피어 의존성 설치
RUN yarn add @typescript-eslint/parser@^5.0.0

# 프로젝트 내의 모든 파일을 복사
COPY . .

# 실행할 명령어 설정
CMD yarn dev