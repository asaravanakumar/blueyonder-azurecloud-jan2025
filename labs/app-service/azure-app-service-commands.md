# Azure App Service - CLI Commands

## Azure Login

```
az login
az login --tenant <tenant-id>
```

### a) connect to your Azure cloud over browser

### b) enter credentials

### c) enter subscription id

## Verify Azure accounts

```
az account list
```

## Deploy Spring Boot jar file into App Service

```
az webapp deploy --resource-group azure-labs --name azure-greetingsapp --src-path azure-app-service-demo.jar
```