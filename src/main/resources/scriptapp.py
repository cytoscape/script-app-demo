# import sys
# import subprocess
# subprocess.check_call([sys.executable, '-m', 'pip', 'install',
# 'py4cytoscape'])

import py4cytoscape as p4c

# p4c.cytoscape_version_info()

# p4c.open_session()

p4c.select_nodes(["MIG1"],"COMMON")
p4c.select_first_neighbors()
p4c.create_subnetwork("selected")
p4c.layout_network("force-directed")