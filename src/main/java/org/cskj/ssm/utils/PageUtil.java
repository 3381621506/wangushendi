package org.cskj.ssm.utils;

public class PageUtil {

	private int count;

	private int pageSize;

	private int currentPage;

	private int prevPage;

	private int nextPage;

	private int pageCount;

	private int startRecord;

	public PageUtil(String currentPage, int count, int pageSize) {
		initCurrentPage(currentPage);
		initPrevPage();
		this.count = count;
		this.pageSize = pageSize;
		initPageCount();
		initNextPage();
		initStartRecord();
	}

	private void initStartRecord() {
		startRecord = (currentPage - 1) * pageSize;
	}

	private void initNextPage() {
		if (currentPage == pageCount) {
			nextPage = pageCount;
		} else {
			nextPage = currentPage + 1;
		}
	}

	private void initPageCount() {
		pageCount = count / pageSize;
		if (count % pageSize != 0) {
			pageCount++;
		}
	}

	private void initPrevPage() {
		if (currentPage == 1) {
			prevPage = 1;
		} else {
			prevPage = currentPage - 1;
		}
	}

	private void initCurrentPage(String page) {
		if (page == null) {
			page = "1";
		}
		if (page.equals("")) {
			page = "1";
		}
		this.currentPage = Integer.parseInt(page);
	}

	public int getCount() {
		return count;
	}

	public int getPageSize() {
		return pageSize;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public int getPrevPage() {
		return prevPage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public int getPageCount() {
		return pageCount;
	}

	public int getStartRecord() {
		return startRecord;
	}

}
