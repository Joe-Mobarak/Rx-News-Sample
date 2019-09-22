package base

data class Resource<T>(val status: Int, val data: T?) {
    companion object {
        const val STATUS_LOADING = 0
        const val STATUS_SUCCESS = 1
        const val STATUS_ERROR = -1
        const val STATUS_NO_INTERNET = 0
    }
}
