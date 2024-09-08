resource "aws_dynamodb_table" "elements_table" {
  name           = "Elements"
  billing_mode   = "PROVISIONED"
  hash_key       = "AtomicNumber" 

  # Define attributes for the table
  attribute {
    name = "AtomicNumber"
    type = "N"
  }
  
  read_capacity = 5
  write_capacity = 5
}
