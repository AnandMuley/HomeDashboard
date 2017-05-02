import { HomeDashboardPage } from './app.po';

describe('home-dashboard App', function() {
  let page: HomeDashboardPage;

  beforeEach(() => {
    page = new HomeDashboardPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
