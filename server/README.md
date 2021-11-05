# Server Side

## Project Structure

```bash
server
├── src
│   ├── auth
│   │   ├── guards
│   │   └── strategies
│   ├── db
│   │   └── migrations
│   ├── postings
│   │   ├── dto
│   │   └── entities
│   └── users
│       ├── dto
│       └── entities
└── test
```

## How to Start

#### Change Directory

```bash
$ cd server
```

#### Installation

```bash
$ npm install
```

#### Data Migration

```bash
$ npm run migration:run
```

#### Running the app

```bash
# development
$ npm run start
```
