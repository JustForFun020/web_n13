// hiển thị báo cáo tổng hợp, chi tiết, bảng xếp hạng
const reportSummary = document.querySelector('.baocao__tonghop');
const reportDetails = document.querySelector('.baocao__chitiet');
const reportRanking = document.querySelector('.baocao__bangxephang');
const listBtnReport = document.querySelectorAll('.baocao__danhsach--nut');
listBtnReport.forEach((item, index) =>
  item.addEventListener('click', () => {
    listBtnReport.forEach((otherItem) => {
      otherItem.classList.remove('active');
      otherItem.classList.remove('li--visited');
      otherItem.classList.add('baocao__danhsach--nut');
    });
    item.classList.add('active');
    item.classList.add('li--visited');
    item.classList.remove('baocao__danhsach--nut');
    if (index === 0) {
      reportSummary.classList.add('show');
      reportSummary.classList.remove('hide');
      reportDetails.classList.remove('show');
      reportDetails.classList.add('hide');
      reportRanking.classList.remove('show');
      reportRanking.classList.add('hide');
    } else if (index === 1) {
      reportSummary.classList.remove('show');
      reportSummary.classList.add('hide');
      reportDetails.classList.add('show');
      reportDetails.classList.remove('hide');
      reportRanking.classList.remove('show');
      reportRanking.classList.add('hide');
    } else {
      reportSummary.classList.remove('show');
      reportSummary.classList.add('hide');
      reportDetails.classList.remove('show');
      reportDetails.classList.add('hide');
      reportRanking.classList.add('show');
      reportRanking.classList.remove('hide');
    }
  })
);
