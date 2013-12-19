def dtime = ( manager.build.getDurationString() =~ /(\d+)/ )
def regex = ( manager.build.project =~ /\[(.*)\]/ )
def base = "http://jenkins.aws.ecnext.net:8080/job/${ regex[0][1] }/${ manager.build.number }/Results"

manager.addBadge("/images/16x16/hourglass.gif", "Duration: ~${ dtime[0][1] } seconds")
manager.addBadge("text.gif", "HTML Report", "$base")
manager.addBadge("info.gif", "Build SHAs", "$base/stack_file.txt")
