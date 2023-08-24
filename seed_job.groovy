job('hello-world-2') {
  steps {
    shell('echo "Hello World!"')
    shell("vi")
  }
}
