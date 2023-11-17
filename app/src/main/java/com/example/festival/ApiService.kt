package com.example.festival

import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.*

interface LogInService {  // 로그인
    @POST
    fun sendLogInRequest(@Url url: String, @Body login: Login): Call<Void>
}

interface AuthJoinService { // 회원가입
    // "api 경로"
    // 함수명(서버에 보내는 데이터:Body 변수명: 데이터타입): Call<서버에 받아오는 데이터 형태>
    @POST("auth/join")
    fun sendAuthRequest(@Body join: Join): Call<Void>
}

interface MyPageService {
    @GET("user/mypage")
    fun getUser(@Header("Authorization") authToken: String): Call<User>
}

interface UserUpdateService {
    @Multipart
    @PATCH("user/update")
    fun sendUserUpdate(@Header("Authorization") authToken: String,
                       @Part("user") user: UserUpdate, @Part image: MultipartBody.Part): Call<Void>
}

interface FestivalListService {  // 페스티벌 리스트
    @GET("festival/list")
    fun getFestivalList(): Call<List<Festival>>
}

interface FestivalDetailService {  // 페스티벌 상세
    @GET("festival/detail")
    fun getFestival(@Query("festivalId") festivalId: Int): Call<Festival>
}

interface EventListService {  // 이벤트 리스트
    @GET("event/list")
    fun getEventList(): Call<List<Event>>
}

interface EventDetailService {  // 이벤트 상세
    @GET("event/detail")
    fun getEvent(@Query("eventId") eventId: Int): Call<Event>
}

interface BoardService {  // 게시판 작성
    @POST("partner") // 서버 주소/partner 으로 POST
    fun sendBoard(@Part("partner") board: Board, @Part image: MultipartBody.Part,
        @Header("Authorization") authToken: String): Call<Void>
}

interface BoardListService {  // 게시판 리스트
    @GET("partner")
    fun getBoardList(): Call<List<BoardData>>
}

interface BoardDetailService {  // 게시판 상세
    @GET("partner/{partnerId}")
    fun getBoard(@Path("partnerId") boardId: Int): Call<BoardData>
}

interface ModBoardService {  // 게시판 수정
    @PATCH("partner/{partnerId}")
    fun sendModBoard(@Path("partnerId") boardId: Int,
                     @Part("partner") board: Board, @Part image: MultipartBody.Part,
                     @Header("Authorization") authToken: String): Call<Void>
}

interface DeleteBoardService {  // 게시판 삭제
    @DELETE("partner/{partnerId}")
    fun deleteBoardData(@Path("partnerId") boardId: Int): Call<Void>
}

interface CommentService {  // 게시판 댓글 작성
    @POST("comment/{partnerId}")
    fun sendComment(
        @Path("partnerId") partnerId: Int, @Header("Authorization") authToken: String,
        @Body comment: Comment
    ): Call<Void>
}

interface CommentListService { // 게시판 댓글 조회
    @GET("comment/{partnerId}")
    fun getCommentListData(@Path("partnerId") partnerId: Int): Call<List<CommentListResponse>>
}

interface ReportService {
    @POST("report")
    fun sendReport(@Header("Authorization") authToken: String,
                @Part("partner") report: Report, @Part image: MultipartBody.Part,
    ): Call<Void>
}

interface ReportListService {  // 신고 리스트
    @GET("report")
    fun getReportList(): Call<List<ReportData>>
}

interface ReportDetailService {  // 신고 상세
    @GET("report/{reportId}")
    fun getReport(@Path("reportId") reportId: Int): Call<ReportData>
}

interface ModReportService {  // 신고 수정
    @PATCH("report/{reportId}")
    fun sendModReport(@Path("reportId") reportId: Int,
                      @Part("partner") report: Report, @Part image: MultipartBody.Part,
                     @Header("Authorization") authToken: String): Call<Void>
}

interface DeleteReportService {  // 신고 삭제
    @DELETE("report/{reportId}")
    fun deleteReportData(@Path("reportId") reportId: Int): Call<Void>
}