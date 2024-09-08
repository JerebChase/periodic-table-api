

module "s3_import_object_csv" {
  source  = "terraform-aws-modules/s3-bucket/aws//modules/object"
  version = "~> 3.15"

  bucket = module.s3_bucket.s3_bucket_id
  key    = "import-csv-${random_pet.this.id}/sample.csv"

  content_base64 = filebase64("../data/PeriodicTableOfElements.csv")
}
