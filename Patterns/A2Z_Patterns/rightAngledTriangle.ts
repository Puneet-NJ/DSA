const constructRAT = (n: number) => {
	for (let i = 0; i < n; i++) {
		for (let j = 0; j <= i; j++) {
			process.stdout.write(`${i + 1}`);
		}
		console.log();
	}
};

constructRAT(5);
