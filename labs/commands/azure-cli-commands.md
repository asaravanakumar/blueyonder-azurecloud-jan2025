# Azure Labs - CLI Commands

## Install Azure CLI

## Verify Installation

```
az version
```

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

## Azure VM

```
az vm list --resource-group azure-labs --output table
az vm show --name azure-linus-vm --output json
az vm show --resource-group azure-labs --name azure-linux-vm --output json
az vm list -d --query "[].{Name:name, Status:powerState}" --output table
az vm stop --resource-group azure-labs --name azure-linux-vm
az vm stop --resource-group azure-labs --name azure-windows-vm
az vm list -d --query "[].{Name:name, Status:powerState}" --output table
az vm start --resource-group azure-labs --name azure-windows-vm
```

## Launch VM using Azure CLI

### Set the variables

```
export RESOURCE_GROUP="azure-labs-cli"
export LOCATION="centralindia"

export VM_NAME="azure-linux-cli-vm"
export IMAGE="Ubuntu2404Pro"
export SIZE="Standard_B2ats_V2"
export ADMIN_USER="azureuser"
export ADMIN_PASSWORD="MyStrongP@ssw0rd!"
export SSH_KEY_PATH="$HOME/.ssh/id_rsa.pub"

```

### Create Resource Group

```
az group create --name $RESOURCE_GROUP --location $LOCATION
```

### Create VM

```
az vm create \
    --resource-group $RESOURCE_GROUP \
    --name $VM_NAME \
    --image $IMAGE \
    --size $SIZE \
    --admin-username $ADMIN_USER \
    --admin-password $ADMIN_PASSWORD \
    --public-ip-sku Standard
    --authentication-type password
```
