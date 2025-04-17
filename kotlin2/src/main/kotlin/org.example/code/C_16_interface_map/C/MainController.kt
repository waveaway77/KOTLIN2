package code.C_16_interface_map.C

@RequestMapping(/{mainId})
class MainController(private val mainServiceFactory: MainServiceFactory) { // 생성자 주입으로 객체 생성
    @ModelAttribute
    fun resloveMainService(@PathVariable mainId: String): MainService {
        return mainServiceFactory.getService(mainId) // id 별로 원하는 서비스를 호출함
    }
}