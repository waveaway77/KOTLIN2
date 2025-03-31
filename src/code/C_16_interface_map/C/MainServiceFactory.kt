package code.C_16_interface_map.C

@Component
class MainServiceFactory(private val mainSErvice: Map<String, MainService>) { // (인터페이스를 구현한.. @서비스 목록을 나열한다)
    fun getService(mainId: String): MainService {
        return mainService[mainId.lowercase()] ?: throw IllegalArgumentException("No service found for : $mainId")
    }
}