public int findNum(ArrayReader reader, int k) {
	if (reader.get(0) > k) return -1;

	int aim = 1;
	while (reader.get(aim) < k) {
		aim *= 2;
	}

	if (reader.get(aim) == k) return aim;

	int left = 0, right = aim, mid, temp;
	while (left <= right) {
		mid = left + (right - left) / 2;
		temp = reader.get(mid);
		if (temp == k) return mid;
		else if (temp < k) left = mid + 1;
		else right = mid - 1;
	} 
	return -1;
}