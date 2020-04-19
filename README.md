# aws-ssm-java-lambda-handler
AWS SSM java lambda handler example

## Test Event for lambda

### Get SSM param value
```
{
  "ops": "get",
  "secured": "Y",
  "key": "/bkash/test/priyam"
}
```

### Save SSM param value
```
{
  "ops": "save",
  "secured": "Y",
  "key": "/bkash/test/priyam",
  "value": "srn"
}
```
