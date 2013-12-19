// 
// Forces build status to UNSTABLE if console output includes the unexpected response error
// that pops up occassionally when running tests with PhantomJS.
//

if (manager.logContains('.*unexpected response, code=404, content-type="text/plain".*')) {
  manager.build.@result = hudson.model.Result.UNSTABLE
}
