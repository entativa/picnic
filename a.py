import os
from pathlib import Path

def create_file(path):
    Path(path).parent.mkdir(parents=True, exist_ok=True)
    Path(path).touch(exist_ok=True)

def create_kt(base, path):
    create_file(f"{base}/{path}.kt")

def create_xml(base, path):
    create_file(f"{base}/{path}.xml")

base = "picnic-app"

gradle_files = [
    "gradle/wrapper/gradle-wrapper.properties",
    "gradle/wrapper/gradle-wrapper.jar",
    "build.gradle.kts",
    "settings.gradle.kts",
    "gradle.properties",
    "README.md",
    ".gitignore"
]

for f in gradle_files:
    create_file(f"{base}/{f}")

common_main = f"{base}/composeApp/src/commonMain"
android_main = f"{base}/composeApp/src/androidMain"
ios_main = f"{base}/composeApp/src/iosMain"
desktop_main = f"{base}/composeApp/src/desktopMain"
wasm_main = f"{base}/composeApp/src/wasmJsMain"
common_test = f"{base}/composeApp/src/commonTest"

kt_base = "kotlin/com/picnic/app"

core_files = [
    "App",
    "core/di/AppModule",
    "core/di/NetworkModule",
    "core/di/DatabaseModule",
    "core/di/RepositoryModule",
    "core/di/PlatformModule",
    "core/config/AppConfig",
    "core/config/BuildConfig",
    "core/config/FeatureFlags",
    "core/platform/Platform",
    "core/platform/PlatformContext",
    "core/platform/BiometricAuth",
    "core/platform/HapticFeedback",
    "core/platform/ShareManager",
    "core/utils/DateTimeUtils",
    "core/utils/ValidationUtils",
    "core/utils/FormatUtils",
    "core/utils/CryptoUtils",
    "core/utils/UrlUtils",
    "core/extensions/StringExtensions",
    "core/extensions/FlowExtensions",
    "core/extensions/ComposeExtensions",
    "core/extensions/CollectionExtensions"
]

domain_model_files = [
    "domain/model/user/User",
    "domain/model/user/UserProfile",
    "domain/model/user/UserSettings",
    "domain/model/user/UserStats",
    "domain/model/user/UserVerification",
    "domain/model/user/BlockedUser",
    "domain/model/auth/AuthToken",
    "domain/model/auth/AuthCredentials",
    "domain/model/auth/Session",
    "domain/model/auth/DeviceInfo",
    "domain/model/post/Post",
    "domain/model/post/PostMedia",
    "domain/model/post/PostMetadata",
    "domain/model/post/PostVisibility",
    "domain/model/post/PostType",
    "domain/model/post/Draft",
    "domain/model/feed/FeedItem",
    "domain/model/feed/FeedType",
    "domain/model/feed/FeedPreferences",
    "domain/model/feed/FeedAlgorithm",
    "domain/model/basket/Basket",
    "domain/model/basket/BasketMember",
    "domain/model/basket/BasketPermission",
    "domain/model/basket/BasketInvite",
    "domain/model/basket/BasketSettings",
    "domain/model/hangout/Hangout",
    "domain/model/hangout/HangoutMember",
    "domain/model/hangout/HangoutRole",
    "domain/model/hangout/HangoutPost",
    "domain/model/hangout/HangoutRules",
    "domain/model/hangout/HangoutCategory",
    "domain/model/clip/Clip",
    "domain/model/clip/ClipMetadata",
    "domain/model/clip/ClipAudio",
    "domain/model/clip/ClipEffect",
    "domain/model/clip/ClipDraft",
    "domain/model/social/Friendship",
    "domain/model/social/FollowRequest",
    "domain/model/social/FollowStatus",
    "domain/model/social/Suggestion",
    "domain/model/social/Connection",
    "domain/model/interaction/Like",
    "domain/model/interaction/Comment",
    "domain/model/interaction/Share",
    "domain/model/interaction/Bookmark",
    "domain/model/interaction/Reaction",
    "domain/model/interaction/View",
    "domain/model/messaging/Message",
    "domain/model/messaging/Conversation",
    "domain/model/messaging/ChatMember",
    "domain/model/messaging/MessageStatus",
    "domain/model/messaging/MessageType",
    "domain/model/messaging/TypingIndicator",
    "domain/model/notification/Notification",
    "domain/model/notification/NotificationType",
    "domain/model/notification/NotificationSettings",
    "domain/model/notification/PushToken",
    "domain/model/subscription/Subscription",
    "domain/model/subscription/SubscriptionTier",
    "domain/model/subscription/Payment",
    "domain/model/subscription/PaymentMethod",
    "domain/model/subscription/Transaction",
    "domain/model/subscription/Payout",
    "domain/model/subscription/EarningsReport",
    "domain/model/media/Media",
    "domain/model/media/MediaType",
    "domain/model/media/MediaUpload",
    "domain/model/media/MediaProcessing",
    "domain/model/media/Thumbnail",
    "domain/model/media/MediaCompression",
    "domain/model/search/SearchResult",
    "domain/model/search/SearchQuery",
    "domain/model/search/SearchFilter",
    "domain/model/search/SearchHistory",
    "domain/model/search/TrendingTopic",
    "domain/model/story/Story",
    "domain/model/story/StoryViewer",
    "domain/model/story/StoryHighlight",
    "domain/model/story/StoryReply",
    "domain/model/moderation/Report",
    "domain/model/moderation/ReportReason",
    "domain/model/moderation/ModeratedContent",
    "domain/model/moderation/BanStatus",
    "domain/model/moderation/ModerationAction",
    "domain/model/analytics/Event",
    "domain/model/analytics/UserAnalytics",
    "domain/model/analytics/ContentAnalytics",
    "domain/model/analytics/EngagementMetrics",
    "domain/model/analytics/InsightData",
    "domain/model/location/Location",
    "domain/model/location/Place",
    "domain/model/location/CheckIn",
    "domain/model/location/GeoTag"
]

domain_repository_files = [
    "domain/repository/AuthRepository",
    "domain/repository/UserRepository",
    "domain/repository/PostRepository",
    "domain/repository/FeedRepository",
    "domain/repository/BasketRepository",
    "domain/repository/HangoutRepository",
    "domain/repository/ClipRepository",
    "domain/repository/SocialRepository",
    "domain/repository/MessageRepository",
    "domain/repository/NotificationRepository",
    "domain/repository/SubscriptionRepository",
    "domain/repository/MediaRepository",
    "domain/repository/SearchRepository",
    "domain/repository/StoryRepository",
    "domain/repository/AnalyticsRepository",
    "domain/repository/LocationRepository"
]

domain_usecase_files = [
    "domain/usecase/auth/LoginUseCase",
    "domain/usecase/auth/RegisterUseCase",
    "domain/usecase/auth/LogoutUseCase",
    "domain/usecase/auth/RefreshTokenUseCase",
    "domain/usecase/auth/ValidateEmailUseCase",
    "domain/usecase/auth/ResetPasswordUseCase",
    "domain/usecase/auth/VerifyOTPUseCase",
    "domain/usecase/auth/SocialLoginUseCase",
    "domain/usecase/user/GetUserProfileUseCase",
    "domain/usecase/user/UpdateProfileUseCase",
    "domain/usecase/user/UploadProfilePictureUseCase",
    "domain/usecase/user/UpdateSettingsUseCase",
    "domain/usecase/user/RequestVerificationUseCase",
    "domain/usecase/user/BlockUserUseCase",
    "domain/usecase/user/UnblockUserUseCase",
    "domain/usecase/user/GetBlockedUsersUseCase",
    "domain/usecase/user/DeleteAccountUseCase",
    "domain/usecase/post/CreatePostUseCase",
    "domain/usecase/post/EditPostUseCase",
    "domain/usecase/post/DeletePostUseCase",
    "domain/usecase/post/GetPostDetailsUseCase",
    "domain/usecase/post/SaveDraftUseCase",
    "domain/usecase/post/GetDraftsUseCase",
    "domain/usecase/post/SchedulePostUseCase",
    "domain/usecase/feed/GetFeedUseCase",
    "domain/usecase/feed/RefreshFeedUseCase",
    "domain/usecase/feed/GetExploreFeedUseCase",
    "domain/usecase/feed/GetFollowingFeedUseCase",
    "domain/usecase/feed/UpdateFeedPreferencesUseCase",
    "domain/usecase/feed/HidePostFromFeedUseCase",
    "domain/usecase/basket/CreateBasketUseCase",
    "domain/usecase/basket/EditBasketUseCase",
    "domain/usecase/basket/DeleteBasketUseCase",
    "domain/usecase/basket/GetBasketDetailsUseCase",
    "domain/usecase/basket/AddToBasketUseCase",
    "domain/usecase/basket/RemoveFromBasketUseCase",
    "domain/usecase/basket/InviteToBasketUseCase",
    "domain/usecase/basket/AcceptBasketInviteUseCase",
    "domain/usecase/basket/LeaveBasketUseCase",
    "domain/usecase/basket/UpdateBasketPermissionsUseCase",
    "domain/usecase/hangout/CreateHangoutUseCase",
    "domain/usecase/hangout/EditHangoutUseCase",
    "domain/usecase/hangout/DeleteHangoutUseCase",
    "domain/usecase/hangout/JoinHangoutUseCase",
    "domain/usecase/hangout/LeaveHangoutUseCase",
    "domain/usecase/hangout/InviteToHangoutUseCase",
    "domain/usecase/hangout/GetHangoutPostsUseCase",
    "domain/usecase/hangout/ModerateHangoutUseCase",
    "domain/usecase/hangout/SearchHangoutsUseCase",
    "domain/usecase/clip/CreateClipUseCase",
    "domain/usecase/clip/EditClipUseCase",
    "domain/usecase/clip/DeleteClipUseCase",
    "domain/usecase/clip/GetClipsFeedUseCase",
    "domain/usecase/clip/SaveClipDraftUseCase",
    "domain/usecase/clip/ApplyClipEffectUseCase",
    "domain/usecase/clip/AddClipAudioUseCase",
    "domain/usecase/social/FollowUserUseCase",
    "domain/usecase/social/UnfollowUserUseCase",
    "domain/usecase/social/AcceptFollowRequestUseCase",
    "domain/usecase/social/DeclineFollowRequestUseCase",
    "domain/usecase/social/GetFollowersUseCase",
    "domain/usecase/social/GetFollowingUseCase",
    "domain/usecase/social/GetFollowRequestsUseCase",
    "domain/usecase/social/GetSuggestionsUseCase",
    "domain/usecase/social/CheckFriendshipStatusUseCase",
    "domain/usecase/interaction/LikePostUseCase",
    "domain/usecase/interaction/UnlikePostUseCase",
    "domain/usecase/interaction/CommentOnPostUseCase",
    "domain/usecase/interaction/DeleteCommentUseCase",
    "domain/usecase/interaction/ReplyToCommentUseCase",
    "domain/usecase/interaction/GetCommentsUseCase",
    "domain/usecase/interaction/SharePostUseCase",
    "domain/usecase/interaction/BookmarkPostUseCase",
    "domain/usecase/interaction/UnbookmarkPostUseCase",
    "domain/usecase/interaction/GetBookmarksUseCase",
    "domain/usecase/interaction/ReactToPostUseCase",
    "domain/usecase/interaction/TrackViewUseCase",
    "domain/usecase/messaging/SendMessageUseCase",
    "domain/usecase/messaging/GetConversationsUseCase",
    "domain/usecase/messaging/GetMessagesUseCase",
    "domain/usecase/messaging/MarkAsReadUseCase",
    "domain/usecase/messaging/DeleteMessageUseCase",
    "domain/usecase/messaging/DeleteConversationUseCase",
    "domain/usecase/messaging/CreateGroupChatUseCase",
    "domain/usecase/messaging/AddToChatUseCase",
    "domain/usecase/messaging/RemoveFromChatUseCase",
    "domain/usecase/messaging/SendTypingIndicatorUseCase",
    "domain/usecase/messaging/ForwardMessageUseCase",
    "domain/usecase/notification/GetNotificationsUseCase",
    "domain/usecase/notification/MarkNotificationReadUseCase",
    "domain/usecase/notification/ClearNotificationsUseCase",
    "domain/usecase/notification/UpdateNotificationSettingsUseCase",
    "domain/usecase/notification/RegisterPushTokenUseCase",
    "domain/usecase/notification/UnregisterPushTokenUseCase",
    "domain/usecase/subscription/SubscribeToUserUseCase",
    "domain/usecase/subscription/UnsubscribeFromUserUseCase",
    "domain/usecase/subscription/GetSubscriptionsUseCase",
    "domain/usecase/subscription/GetSubscribersUseCase",
    "domain/usecase/subscription/SetupSubscriptionTierUseCase",
    "domain/usecase/subscription/UpdateSubscriptionTierUseCase",
    "domain/usecase/subscription/ProcessPaymentUseCase",
    "domain/usecase/subscription/RefundPaymentUseCase",
    "domain/usecase/subscription/GetEarningsUseCase",
    "domain/usecase/subscription/RequestPayoutUseCase",
    "domain/usecase/subscription/GetTransactionHistoryUseCase",
    "domain/usecase/media/UploadMediaUseCase",
    "domain/usecase/media/DeleteMediaUseCase",
    "domain/usecase/media/ProcessMediaUseCase",
    "domain/usecase/media/GenerateThumbnailUseCase",
    "domain/usecase/media/CompressMediaUseCase",
    "domain/usecase/media/ValidateMediaUseCase",
    "domain/usecase/search/SearchUsersUseCase",
    "domain/usecase/search/SearchPostsUseCase",
    "domain/usecase/search/SearchHashtagsUseCase",
    "domain/usecase/search/GetTrendingUseCase",
    "domain/usecase/search/SaveSearchHistoryUseCase",
    "domain/usecase/search/ClearSearchHistoryUseCase",
    "domain/usecase/search/GetSearchSuggestionsUseCase",
    "domain/usecase/story/CreateStoryUseCase",
    "domain/usecase/story/DeleteStoryUseCase",
    "domain/usecase/story/GetStoriesUseCase",
    "domain/usecase/story/ViewStoryUseCase",
    "domain/usecase/story/GetStoryViewersUseCase",
    "domain/usecase/story/ReplyToStoryUseCase",
    "domain/usecase/story/CreateHighlightUseCase",
    "domain/usecase/story/DeleteHighlightUseCase",
    "domain/usecase/moderation/ReportContentUseCase",
    "domain/usecase/moderation/ReportUserUseCase",
    "domain/usecase/moderation/AppealBanUseCase",
    "domain/usecase/moderation/GetModerationHistoryUseCase",
    "domain/usecase/analytics/TrackEventUseCase",
    "domain/usecase/analytics/GetUserAnalyticsUseCase",
    "domain/usecase/analytics/GetContentAnalyticsUseCase",
    "domain/usecase/analytics/GetEngagementMetricsUseCase",
    "domain/usecase/analytics/GetInsightsUseCase",
    "domain/usecase/location/GetNearbyPlacesUseCase",
    "domain/usecase/location/SearchPlacesUseCase",
    "domain/usecase/location/CheckInUseCase",
    "domain/usecase/location/GetCheckInsUseCase",
    "domain/usecase/location/AddGeoTagUseCase"
]

data_remote_api_files = [
    "data/remote/api/PicnicApi",
    "data/remote/api/AuthApi",
    "data/remote/api/UserApi",
    "data/remote/api/PostApi",
    "data/remote/api/FeedApi",
    "data/remote/api/BasketApi",
    "data/remote/api/HangoutApi",
    "data/remote/api/ClipApi",
    "data/remote/api/SocialApi",
    "data/remote/api/MessageApi",
    "data/remote/api/NotificationApi",
    "data/remote/api/SubscriptionApi",
    "data/remote/api/MediaApi",
    "data/remote/api/SearchApi",
    "data/remote/api/StoryApi",
    "data/remote/api/ModerationApi",
    "data/remote/api/AnalyticsApi",
    "data/remote/api/LocationApi"
]

data_remote_dto_files = [
    "data/remote/dto/auth/LoginRequestDto",
    "data/remote/dto/auth/LoginResponseDto",
    "data/remote/dto/auth/RegisterRequestDto",
    "data/remote/dto/auth/TokenDto",
    "data/remote/dto/user/UserDto",
    "data/remote/dto/user/ProfileDto",
    "data/remote/dto/user/SettingsDto",
    "data/remote/dto/post/PostDto",
    "data/remote/dto/post/CreatePostDto",
    "data/remote/dto/post/UpdatePostDto",
    "data/remote/dto/feed/FeedItemDto",
    "data/remote/dto/feed/FeedResponseDto",
    "data/remote/dto/basket/BasketDto",
    "data/remote/dto/basket/BasketMemberDto",
    "data/remote/dto/hangout/HangoutDto",
    "data/remote/dto/hangout/HangoutMemberDto",
    "data/remote/dto/clip/ClipDto",
    "data/remote/dto/clip/ClipMetadataDto",
    "data/remote/dto/social/FollowDto",
    "data/remote/dto/social/FriendshipDto",
    "data/remote/dto/interaction/LikeDto",
    "data/remote/dto/interaction/CommentDto",
    "data/remote/dto/messaging/MessageDto",
    "data/remote/dto/messaging/ConversationDto",
    "data/remote/dto/notification/NotificationDto",
    "data/remote/dto/subscription/SubscriptionDto",
    "data/remote/dto/subscription/PaymentDto",
    "data/remote/dto/media/MediaDto",
    "data/remote/dto/media/UploadResponseDto",
    "data/remote/dto/search/SearchResultDto",
    "data/remote/dto/story/StoryDto",
    "data/remote/dto/moderation/ReportDto",
    "data/remote/dto/analytics/EventDto",
    "data/remote/dto/location/LocationDto",
    "data/remote/dto/common/ResponseDto",
    "data/remote/dto/common/ErrorDto",
    "data/remote/dto/common/PaginationDto"
]

data_remote_other_files = [
    "data/remote/interceptor/AuthInterceptor",
    "data/remote/interceptor/LoggingInterceptor",
    "data/remote/interceptor/RetryInterceptor",
    "data/remote/websocket/WebSocketClient",
    "data/remote/websocket/WebSocketListener",
    "data/remote/websocket/MessageHandler"
]

data_local_files = [
    "data/local/database/PicnicDatabase",
    "data/local/database/entity/UserEntity",
    "data/local/database/entity/PostEntity",
    "data/local/database/entity/BasketEntity",
    "data/local/database/entity/HangoutEntity",
    "data/local/database/entity/ClipEntity",
    "data/local/database/entity/MessageEntity",
    "data/local/database/entity/NotificationEntity",
    "data/local/database/entity/DraftEntity",
    "data/local/database/dao/UserDao",
    "data/local/database/dao/PostDao",
    "data/local/database/dao/BasketDao",
    "data/local/database/dao/HangoutDao",
    "data/local/database/dao/ClipDao",
    "data/local/database/dao/MessageDao",
    "data/local/database/dao/NotificationDao",
    "data/local/database/dao/DraftDao",
    "data/local/preferences/AppPreferences",
    "data/local/preferences/UserPreferences",
    "data/local/preferences/SecurityPreferences",
    "data/local/cache/CacheManager",
    "data/local/cache/ImageCache",
    "data/local/cache/VideoCache"
]

data_repository_impl_files = [
    "data/repository/AuthRepositoryImpl",
    "data/repository/UserRepositoryImpl",
    "data/repository/PostRepositoryImpl",
    "data/repository/FeedRepositoryImpl",
    "data/repository/BasketRepositoryImpl",
    "data/repository/HangoutRepositoryImpl",
    "data/repository/ClipRepositoryImpl",
    "data/repository/SocialRepositoryImpl",
    "data/repository/MessageRepositoryImpl",
    "data/repository/NotificationRepositoryImpl",
    "data/repository/SubscriptionRepositoryImpl",
    "data/repository/MediaRepositoryImpl",
    "data/repository/SearchRepositoryImpl",
    "data/repository/StoryRepositoryImpl",
    "data/repository/AnalyticsRepositoryImpl",
    "data/repository/LocationRepositoryImpl"
]

data_mapper_files = [
    "data/mapper/UserMapper",
    "data/mapper/PostMapper",
    "data/mapper/BasketMapper",
    "data/mapper/HangoutMapper",
    "data/mapper/ClipMapper",
    "data/mapper/MessageMapper",
    "data/mapper/NotificationMapper",
    "data/mapper/SubscriptionMapper",
    "data/mapper/MediaMapper",
    "data/mapper/StoryMapper"
]

presentation_theme_files = [
    "presentation/theme/Color",
    "presentation/theme/Theme",
    "presentation/theme/Type",
    "presentation/theme/Shape",
    "presentation/theme/Dimension"
]

presentation_navigation_files = [
    "presentation/navigation/Navigation",
    "presentation/navigation/Screen",
    "presentation/navigation/NavigationGraph",
    "presentation/navigation/DeepLinkHandler"
]

presentation_component_files = [
    "presentation/components/common/PicnicButton",
    "presentation/components/common/PicnicTextField",
    "presentation/components/common/PicnicCard",
    "presentation/components/common/PicnicDialog",
    "presentation/components/common/PicnicBottomSheet",
    "presentation/components/common/PicnicTopBar",
    "presentation/components/common/PicnicBottomBar",
    "presentation/components/common/PicnicFAB",
    "presentation/components/common/PicnicChip",
    "presentation/components/common/LoadingIndicator",
    "presentation/components/common/ErrorView",
    "presentation/components/common/EmptyView",
    "presentation/components/post/PostCard",
    "presentation/components/post/PostHeader",
    "presentation/components/post/PostContent",
    "presentation/components/post/PostActions",
    "presentation/components/post/PostComments",
    "presentation/components/post/CreatePostSheet",
    "presentation/components/user/UserAvatar",
    "presentation/components/user/UserListItem",
    "presentation/components/user/UserProfileHeader",
    "presentation/components/user/UserStatsRow",
    "presentation/components/basket/BasketCard",
    "presentation/components/basket/BasketGrid",
    "presentation/components/basket/BasketMembersList",
    "presentation/components/hangout/HangoutCard",
    "presentation/components/hangout/HangoutHeader",
    "presentation/components/hangout/HangoutMembersList",
    "presentation/components/clip/ClipPlayer",
    "presentation/components/clip/ClipControls",
    "presentation/components/clip/ClipEffects",
    "presentation/components/media/MediaPicker",
    "presentation/components/media/MediaPreview",
    "presentation/components/media/MediaGallery",
    "presentation/components/message/MessageBubble",
    "presentation/components/message/ConversationItem",
    "presentation/components/message/ChatInput",
    "presentation/components/notification/NotificationItem",
    "presentation/components/story/StoryViewer",
    "presentation/components/story/StoryRing",
    "presentation/components/story/StoryCreator",
    "presentation/components/search/SearchBar",
    "presentation/components/search/SearchResults",
    "presentation/components/search/TrendingList"
]

presentation_screen_files = [
    "presentation/screens/splash/SplashScreen",
    "presentation/screens/splash/SplashViewModel",
    "presentation/screens/auth/LoginScreen",
    "presentation/screens/auth/LoginViewModel",
    "presentation/screens/auth/RegisterScreen",
    "presentation/screens/auth/RegisterViewModel",
    "presentation/screens/auth/ForgotPasswordScreen",
    "presentation/screens/auth/ForgotPasswordViewModel",
    "presentation/screens/auth/VerifyOTPScreen",
    "presentation/screens/auth/VerifyOTPViewModel",
    "presentation/screens/onboarding/OnboardingScreen",
    "presentation/screens/onboarding/OnboardingViewModel",
    "presentation/screens/main/MainScreen",
    "presentation/screens/main/MainViewModel",
    "presentation/screens/feed/FeedScreen",
    "presentation/screens/feed/FeedViewModel",
    "presentation/screens/feed/CreatePostScreen",
    "presentation/screens/feed/CreatePostViewModel",
    "presentation/screens/feed/PostDetailScreen",
    "presentation/screens/feed/PostDetailViewModel",
    "presentation/screens/explore/ExploreScreen",
    "presentation/screens/explore/ExploreViewModel",
    "presentation/screens/profile/ProfileScreen",
    "presentation/screens/profile/ProfileViewModel",
    "presentation/screens/profile/EditProfileScreen",
    "presentation/screens/profile/EditProfileViewModel",
    "presentation/screens/profile/FollowersScreen",
    "presentation/screens/profile/FollowersViewModel",
    "presentation/screens/profile/FollowingScreen",
    "presentation/screens/profile/FollowingViewModel",
    "presentation/screens/baskets/BasketsScreen",
    "presentation/screens/baskets/BasketsViewModel",
    "presentation/screens/baskets/BasketDetailScreen",
    "presentation/screens/baskets/BasketDetailViewModel",
    "presentation/screens/baskets/CreateBasketScreen",
    "presentation/screens/baskets/CreateBasketViewModel",
    "presentation/screens/hangouts/HangoutsScreen",
    "presentation/screens/hangouts/HangoutsViewModel",
    "presentation/screens/hangouts/HangoutDetailScreen",
    "presentation/screens/hangouts/HangoutDetailViewModel",
    "presentation/screens/hangouts/CreateHangoutScreen",
    "presentation/screens/hangouts/CreateHangoutViewModel",
    "presentation/screens/hangouts/HangoutMembersScreen",
    "presentation/screens/hangouts/HangoutMembersViewModel",
    "presentation/screens/clips/ClipsScreen",
    "presentation/screens/clips/ClipsViewModel",
    "presentation/screens/clips/CreateClipScreen",
    "presentation/screens/clips/CreateClipViewModel",
    "presentation/screens/clips/EditClipScreen",
    "presentation/screens/clips/EditClipViewModel",
    "presentation/screens/messages/ConversationsScreen",
    "presentation/screens/messages/ConversationsViewModel",
    "presentation/screens/messages/ChatScreen",
    "presentation/screens/messages/ChatViewModel",
    "presentation/screens/messages/NewMessageScreen",
    "presentation/screens/messages/NewMessageViewModel",
    "presentation/screens/messages/GroupChatScreen",
    "presentation/screens/messages/GroupChatViewModel",
    "presentation/screens/notifications/NotificationsScreen",
    "presentation/screens/notifications/NotificationsViewModel",
    "presentation/screens/search/SearchScreen",
    "presentation/screens/search/SearchViewModel",
    "presentation/screens/search/SearchResultsScreen",
    "presentation/screens/search/SearchResultsViewModel",
    "presentation/screens/subscription/SubscriptionScreen",
    "presentation/screens/subscription/SubscriptionViewModel",
    "presentation/screens/subscription/ManageSubscriptionsScreen",
    "presentation/screens/subscription/ManageSubscriptionsViewModel",
    "presentation/screens/subscription/EarningsScreen",
    "presentation/screens/subscription/EarningsViewModel",
    "presentation/screens/subscription/PayoutScreen",
    "presentation/screens/subscription/PayoutViewModel",
    "presentation/screens/settings/SettingsScreen",
    "presentation/screens/settings/SettingsViewModel",
    "presentation/screens/settings/AccountSettingsScreen",
    "presentation/screens/settings/AccountSettingsViewModel",
    "presentation/screens/settings/PrivacySettingsScreen",
    "presentation/screens/settings/PrivacySettingsViewModel",
    "presentation/screens/settings/NotificationSettingsScreen",
    "presentation/screens/settings/NotificationSettingsViewModel",
    "presentation/screens/settings/SecuritySettingsScreen",
    "presentation/screens/settings/SecuritySettingsViewModel",
    "presentation/screens/settings/BlockedUsersScreen",
    "presentation/screens/settings/BlockedUsersViewModel",
    "presentation/screens/story/StoriesScreen",
    "presentation/screens/story/StoriesViewModel",
    "presentation/screens/story/StoryViewerScreen",
    "presentation/screens/story/StoryViewerViewModel",
    "presentation/screens/story/CreateStoryScreen",
    "presentation/screens/story/CreateStoryViewModel",
    "presentation/screens/story/HighlightsScreen",
    "presentation/screens/story/HighlightsViewModel",
    "presentation/screens/bookmarks/BookmarksScreen",
    "presentation/screens/bookmarks/BookmarksViewModel",
    "presentation/screens/analytics/AnalyticsScreen",
    "presentation/screens/analytics/AnalyticsViewModel",
    "presentation/screens/analytics/InsightsScreen",
    "presentation/screens/analytics/InsightsViewModel",
    "presentation/screens/verification/VerificationScreen",
    "presentation/screens/verification/VerificationViewModel",
    "presentation/screens/report/ReportScreen",
    "presentation/screens/report/ReportViewModel"
]

presentation_state_files = [
    "presentation/state/AuthState",
    "presentation/state/FeedState",
    "presentation/state/ProfileState",
    "presentation/state/MessageState",
    "presentation/state/NotificationState",
    "presentation/state/LoadingState",
    "presentation/state/ErrorState"
]

presentation_event_files = [
    "presentation/event/AuthEvent",
    "presentation/event/FeedEvent",
    "presentation/event/ProfileEvent",
    "presentation/event/MessageEvent",
    "presentation/event/NotificationEvent"
]

util_files = [
    "util/NetworkResult",
    "util/Resource",
    "util/Constants",
    "util/Logger",
    "util/ImageUtils",
    "util/VideoUtils",
    "util/AudioUtils",
    "util/FileUtils",
    "util/NetworkUtils",
    "util/PermissionUtils"
]

for f in core_files:
    create_kt(f"{common_main}/{kt_base}", f)

for f in domain_model_files:
    create_kt(f"{common_main}/{kt_base}", f)

for f in domain_repository_files:
    create_kt(f"{common_main}/{kt_base}", f)

for f in domain_usecase_files:
    create_kt(f"{common_main}/{kt_base}", f)

for f in data_remote_api_files:
    create_kt(f"{common_main}/{kt_base}", f)

for f in data_remote_dto_files:
    create_kt(f"{common_main}/{kt_base}", f)

for f in data_remote_other_files:
    create_kt(f"{common_main}/{kt_base}", f)

for f in data_local_files:
    create_kt(f"{common_main}/{kt_base}", f)

for f in data_repository_impl_files:
    create_kt(f"{common_main}/{kt_base}", f)

for f in data_mapper_files:
    create_kt(f"{common_main}/{kt_base}", f)

for f in presentation_theme_files:
    create_kt(f"{common_main}/{kt_base}", f)

for f in presentation_navigation_files:
    create_kt(f"{common_main}/{kt_base}", f)

for f in presentation_component_files:
    create_kt(f"{common_main}/{kt_base}", f)

for f in presentation_screen_files:
    create_kt(f"{common_main}/{kt_base}", f)

for f in presentation_state_files:
    create_kt(f"{common_main}/{kt_base}", f)

for f in presentation_event_files:
    create_kt(f"{common_main}/{kt_base}", f)

for f in util_files:
    create_kt(f"{common_main}/{kt_base}", f)

create_xml(f"{common_main}/resources/values", "strings")
create_file(f"{common_main}/resources/drawable/.gitkeep")
create_file(f"{common_main}/resources/font/.gitkeep")

android_files = [
    "MainActivity",
    "PicnicApplication",
    "di/AndroidModule",
    "platform/AndroidPlatform",
    "platform/CameraManager",
    "platform/MediaPicker",
    "platform/NotificationManager",
    "platform/BiometricManager",
    "platform/LocationManager",
    "platform/FileManager",
    "platform/ShareManager",
    "service/MessagingService",
    "service/MediaService",
    "receiver/BootReceiver",
    "receiver/NetworkReceiver",
    "worker/SyncWorker",
    "worker/UploadWorker"
]

for f in android_files:
    create_kt(f"{android_main}/{kt_base}", f)

create_file(f"{android_main}/AndroidManifest.xml")
create_file(f"{android_main}/res/values/strings.xml")
create_file(f"{android_main}/res/values/colors.xml")
create_file(f"{android_main}/res/values/themes.xml")
create_file(f"{android_main}/res/drawable/.gitkeep")
create_file(f"{android_main}/res/mipmap-hdpi/.gitkeep")
create_file(f"{android_main}/res/mipmap-mdpi/.gitkeep")
create_file(f"{android_main}/res/mipmap-xhdpi/.gitkeep")
create_file(f"{android_main}/res/mipmap-xxhdpi/.gitkeep")
create_file(f"{android_main}/res/mipmap-xxxhdpi/.gitkeep")

ios_files = [
    "MainViewController",
    "di/IosModule",
    "platform/IosPlatform",
    "platform/CameraManager",
    "platform/MediaPicker",
    "platform/NotificationManager",
    "platform/BiometricManager",
    "platform/LocationManager",
    "platform/FileManager",
    "platform/ShareManager"
]

for f in ios_files:
    create_kt(f"{ios_main}/{kt_base}", f)

desktop_files = [
    "main",
    "di/DesktopModule",
    "platform/DesktopPlatform",
    "platform/FileManager",
    "platform/WindowManager",
    "platform/ClipboardManager"
]

for f in desktop_files:
    create_kt(f"{desktop_main}/{kt_base}", f)

wasm_files = [
    "main",
    "di/WebModule",
    "platform/WebPlatform",
    "platform/BrowserStorage",
    "platform/FileManager",
    "platform/ClipboardManager"
]

for f in wasm_files:
    create_kt(f"{wasm_main}/{kt_base}", f)

test_files = [
    "domain/usecase/auth/LoginUseCaseTest",
    "domain/usecase/post/CreatePostUseCaseTest",
    "domain/usecase/social/FollowUserUseCaseTest",
    "data/repository/AuthRepositoryImplTest",
    "data/repository/PostRepositoryImplTest",
    "util/TestUtil",
    "util/MockFactory"
]

for f in test_files:
    create_kt(f"{common_test}/{kt_base}", f)

create_file(f"{base}/composeApp/build.gradle.kts")

ios_app_files = [
    "iosApp/iosApp/iOSApp.swift",
    "iosApp/iosApp/ContentView.swift",
    "iosApp/iosApp/Assets.xcassets/AppIcon.appiconset/Contents.json",
    "iosApp/iosApp/Assets.xcassets/Contents.json",
    "iosApp/iosApp/Info.plist",
    "iosApp/iosApp.xcodeproj/project.pbxproj",
    "iosApp/Configuration/Config.xcconfig"
]

for f in ios_app_files:
    create_file(f"{base}/{f}")

server_files = [
    "server/src/main/kotlin/com/picnic/server/Application.kt",
    "server/src/main/kotlin/com/picnic/server/plugins/Routing.kt",
    "server/src/main/kotlin/com/picnic/server/plugins/Security.kt",
    "server/src/main/kotlin/com/picnic/server/plugins/Serialization.kt",
    "server/src/main/kotlin/com/picnic/server/plugins/Database.kt",
    "server/src/main/kotlin/com/picnic/server/plugins/WebSockets.kt",
    "server/src/main/kotlin/com/picnic/server/routes/AuthRoutes.kt",
    "server/src/main/kotlin/com/picnic/server/routes/UserRoutes.kt",
    "server/src/main/kotlin/com/picnic/server/routes/PostRoutes.kt",
    "server/src/main/kotlin/com/picnic/server/routes/FeedRoutes.kt",
    "server/src/main/kotlin/com/picnic/server/routes/BasketRoutes.kt",
    "server/src/main/kotlin/com/picnic/server/routes/HangoutRoutes.kt",
    "server/src/main/kotlin/com/picnic/server/routes/ClipRoutes.kt",
    "server/src/main/kotlin/com/picnic/server/routes/MessageRoutes.kt",
    "server/src/main/kotlin/com/picnic/server/routes/NotificationRoutes.kt",
    "server/src/main/kotlin/com/picnic/server/routes/SubscriptionRoutes.kt",
    "server/src/main/kotlin/com/picnic/server/routes/MediaRoutes.kt",
    "server/src/main/kotlin/com/picnic/server/routes/SearchRoutes.kt",
    "server/src/main/kotlin/com/picnic/server/routes/StoryRoutes.kt",
    "server/src/main/kotlin/com/picnic/server/routes/AnalyticsRoutes.kt",
    "server/src/main/kotlin/com/picnic/server/data/models/User.kt",
    "server/src/main/kotlin/com/picnic/server/data/models/Post.kt",
    "server/src/main/kotlin/com/picnic/server/data/models/Basket.kt",
    "server/src/main/kotlin/com/picnic/server/data/models/Hangout.kt",
    "server/src/main/kotlin/com/picnic/server/data/models/Clip.kt",
    "server/src/main/kotlin/com/picnic/server/data/models/Message.kt",
    "server/src/main/kotlin/com/picnic/server/data/models/Notification.kt",
    "server/src/main/kotlin/com/picnic/server/data/models/Subscription.kt",
    "server/src/main/kotlin/com/picnic/server/data/database/DatabaseFactory.kt",
    "server/src/main/kotlin/com/picnic/server/data/database/tables/Users.kt",
    "server/src/main/kotlin/com/picnic/server/data/database/tables/Posts.kt",
    "server/src/main/kotlin/com/picnic/server/data/database/tables/Baskets.kt",
    "server/src/main/kotlin/com/picnic/server/data/database/tables/Hangouts.kt",
    "server/src/main/kotlin/com/picnic/server/data/database/tables/Clips.kt",
    "server/src/main/kotlin/com/picnic/server/data/database/tables/Messages.kt",
    "server/src/main/kotlin/com/picnic/server/data/database/tables/Notifications.kt",
    "server/src/main/kotlin/com/picnic/server/data/database/tables/Subscriptions.kt",
    "server/src/main/kotlin/com/picnic/server/services/AuthService.kt",
    "server/src/main/kotlin/com/picnic/server/services/UserService.kt",
    "server/src/main/kotlin/com/picnic/server/services/PostService.kt",
    "server/src/main/kotlin/com/picnic/server/services/FeedService.kt",
    "server/src/main/kotlin/com/picnic/server/services/BasketService.kt",
    "server/src/main/kotlin/com/picnic/server/services/HangoutService.kt",
    "server/src/main/kotlin/com/picnic/server/services/ClipService.kt",
    "server/src/main/kotlin/com/picnic/server/services/MessageService.kt",
    "server/src/main/kotlin/com/picnic/server/services/NotificationService.kt",
    "server/src/main/kotlin/com/picnic/server/services/SubscriptionService.kt",
    "server/src/main/kotlin/com/picnic/server/services/MediaService.kt",
    "server/src/main/kotlin/com/picnic/server/services/SearchService.kt",
    "server/src/main/kotlin/com/picnic/server/services/StoryService.kt",
    "server/src/main/kotlin/com/picnic/server/services/AnalyticsService.kt",
    "server/src/main/kotlin/com/picnic/server/services/EmailService.kt",
    "server/src/main/kotlin/com/picnic/server/services/PushService.kt",
    "server/src/main/kotlin/com/picnic/server/services/StorageService.kt",
    "server/src/main/kotlin/com/picnic/server/services/PaymentService.kt",
    "server/src/main/kotlin/com/picnic/server/util/JwtConfig.kt",
    "server/src/main/kotlin/com/picnic/server/util/HashingUtil.kt",
    "server/src/main/kotlin/com/picnic/server/util/ValidationUtil.kt",
    "server/src/main/resources/application.conf",
    "server/src/main/resources/logback.xml",
    "server/build.gradle.kts"
]

for f in server_files:
    create_file(f"{base}/{f}")

create_file(f"{base}/shared/build.gradle.kts")

print(f"✅ Picnic app structure scaffolded successfully at '{base}/'")
print(f"📦 Total files created: {len([f for f in Path(base).rglob('*') if f.is_file()])}")
