const constructSquare = (n: number) => {
	for (let i = 0; i < n; i++) {
		for (let j = 0; j < n; j++) {
			process.stdout.write("*");
		}
		console.log("");
	}
};

constructSquare(5);
