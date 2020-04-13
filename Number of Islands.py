islandGrid1 = [
	"11110",
	"11010",
	"11000",
	"00000"
]

islandGrid2 = [
	"11000",
	"11000",
	"00100",
	"00011"
]

islandGrid3 = [
	"11110",
	"00010",
	"00010",
	"11110"
]



def solve(grid):
	def bfs(start):
		q = [start]
		while q:
			y, x = q.pop(0)
			grid[y][x] = "2"
			if y > 0:
				if grid[y - 1][x] == "1":
					q.append((y - 1, x))
			if y < r - 1:
				if grid[y + 1][x] == "1":
					q.append((y + 1, x))
			if x > 0:
				if grid[y][x - 1] == "1":
					q.append((y, x - 1))
			if x < c - 1:
				if grid[y][x + 1] == "1":
					q.append((y, x + 1))

	r = len(grid)
	if r == 0: return 0;
	c = len(grid[0])
	islands = 0

	# convert to char array
	for i in range(r):
		row = grid[i]
		grid[i] = []
		for elm in row:
			grid[i].append(elm)

	start = None
	for i in range(r):
		for j in range(c):
			if grid[i][j] == "1":
				islands += 1
				bfs((i, j))

	return(islands)

print("No if Islands", solve(islandGrid1))
print("No if Islands", solve(islandGrid2))
print("No if Islands", solve(islandGrid3))
