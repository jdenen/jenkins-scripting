//
// Adds three icons to the Build History widget for each build.
//   1. Clock icon with test duration tooltip (based on RSpec output "Finished in ...")
//   2. Document icon with link to HTML report
//   3. Info icon with link to environment SHA information
//
// Requires the htmlpublisher plugin archiving a report called 'Results'.
//

def regex = ( manager.build.project =~ /\[(.*)\]/ )
def base = "${ manager.hudson.getRootUrl() }job/${ regex[0][1] }/${ manager.build.number }/Results"

manager.addBadge("/images/16x16/hourglass.gif", "Duration: ${ manager.getLogMatcher(".*Finished in (.*)\$").group(1) }")
manager.addBadge("text.gif", "HTML Report", "$base")
manager.addBadge("info.gif", "Build SHAs", "$base/stack_file.txt")
