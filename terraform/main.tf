provider "aws" {
  region = "us-east-1"
}

module "my_dynamodb_table" {
  source = "./dynamodb"
}
