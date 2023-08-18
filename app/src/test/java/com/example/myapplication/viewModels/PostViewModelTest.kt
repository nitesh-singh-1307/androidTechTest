package com.example.myapplication.viewModels

import PostRepository
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.myapplication.models.Post
import com.example.myapplication.models.Verse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.TestCoroutineScope
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
@ExperimentalCoroutinesApi
class PostViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repository: PostRepository
    private lateinit var viewModel: PostViewModel
    private lateinit var testDispatcher: TestCoroutineDispatcher
    private lateinit var endPoint:String
    private lateinit var testCoroutineScope:TestCoroutineScope


//    private lateinit var mockObserver: Observer<LiveData<Post>>

    @Before
    fun setUp() {
//        MockitoAnnotations.initMocks(this)
        MockitoAnnotations.openMocks(this)
        Dispatchers.setMain(Dispatchers.Unconfined)
testDispatcher = TestCoroutineDispatcher()
        testCoroutineScope = TestCoroutineScope(testDispatcher)
        repository = mock(PostRepository::class.java)
        viewModel = PostViewModel(repository)
        endPoint = "https://bible-api.com/john%203:16"
//        mockObserver = mock(Observer::class.java) as Observer<LiveData<Post>>
    }

    @Test
    fun fetchPosts() = testDispatcher.runBlockingTest{
        // Arrange
        val reference = "123"
        val verses = listOf(Verse("1", "Book", 1, 1, "Text"))
        val text = "Post Text"
        val translationId = "en"
        val translationName = "English"
        val translationNote = "Translation Note"

        // Act
        val post = Post(reference, verses, text, translationId, translationName, translationNote)

        Mockito.`when`(repository.getPosts(endPoint)).thenReturn(post)

        // Act
        viewModel.fetchPosts(endPoint)
        verify(repository).getPosts(endPoint)

        // Assert
//        val liveDataValue = LiveDataTestUtil.getValue(viewModel.posts)
//        assertEquals(post, liveDataValue)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain() // Reset the Main dispatcher after the test
        testDispatcher.cleanupTestCoroutines()
    }
    @After
    fun cleanup(){
        testCoroutineScope.cleanupTestCoroutines()
    }
}