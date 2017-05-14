package com.example.mobsoft.myapplication.test;

import com.example.mobsoft.myapplication.BuildConfig;
import com.example.mobsoft.myapplication.model.Concert;
import com.example.mobsoft.myapplication.ui.detail.DetailPresenter;
import com.example.mobsoft.myapplication.ui.detail.DetailScreen;
import com.example.mobsoft.myapplication.ui.list.ListPresenter;
import com.example.mobsoft.myapplication.ui.list.ListScreen;
import com.example.mobsoft.myapplication.ui.newconcert.NewconcertPresenter;
import com.example.mobsoft.myapplication.ui.newconcert.NewconcertScreen;
import com.example.mobsoft.myapplication.utils.RobolectricDaggerTestRunner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.annotation.Config;

import java.util.List;

import static com.example.mobsoft.myapplication.TestHelper.setTestInjector;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@RunWith(RobolectricDaggerTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class ConcertsTest {
    private ListPresenter listPresenter;
    private DetailPresenter detailPresenter;
    private NewconcertPresenter newconcertPresenter;

    @Before
    public void setup() throws Exception {
        setTestInjector();
        listPresenter = new ListPresenter();
        detailPresenter = new DetailPresenter();
        newconcertPresenter = new NewconcertPresenter();
    }

    @Test
    public void testListConcerts() {
        ListScreen listScreen = mock(ListScreen.class);
        listPresenter.attachScreen(listScreen);

        listPresenter.updateConcerts();
        verify(listScreen, times(1)).showList();
        List<Concert> concerts = listPresenter.getConcerts();
        assertTrue(concerts.size() > 0);
    }

    @Test
    public void testDetailConcert() {
        DetailScreen detailScreen = mock(DetailScreen.class);
        detailPresenter.attachScreen(detailScreen);

        detailPresenter.updateConcert(1L);
        verify(detailScreen, times(1)).showDetails();
        Concert concert = detailPresenter.getConcert();
        assertTrue(concert != null && concert.getId().equals(1L));
    }

    @Test
    public void testDetailConcertError() {
        DetailScreen detailScreen = mock(DetailScreen.class);
        detailPresenter.attachScreen(detailScreen);

        detailPresenter.updateConcert(56934L);
        verify(detailScreen, times(1)).showMessage(anyString());
        Concert concert = detailPresenter.getConcert();
        assertTrue(concert == null);
    }

    @Test
    public void testNewConcert() {
        NewconcertScreen newconcertScreen = mock(NewconcertScreen.class);
        newconcertPresenter.attachScreen(newconcertScreen);
        DetailScreen detailScreen = mock(DetailScreen.class);
        detailPresenter.attachScreen(detailScreen);

        newconcertPresenter.saveConcert(new Concert(100L, "newconcert", null, null, null, null, false));
        verify(newconcertScreen, times(1)).showListScreen();
        detailPresenter.updateConcert(100L);
        verify(detailScreen, times(1)).showDetails();
        Concert concert = detailPresenter.getConcert();
        assertTrue(concert != null && concert.getId().equals(100L));
    }

    @After
    public void tearDown() {
        listPresenter.detachScreen();
        detailPresenter.detachScreen();
        newconcertPresenter.detachScreen();
    }
}
