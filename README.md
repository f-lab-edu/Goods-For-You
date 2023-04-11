# Goods-For-You

K-POP 스타뿐만 아니라 인플루언서 및 스포츠스타들의 굿즈 등을 간단하고 쉽게 판매 등록 및 구매,교환 할 수 있도록 구축한 플랫폼입니다.

## 🎯 프로젝트 목표

### 코드 컨벤션

- Naver Code Style을 적용해, 준수합니다
- Check Style 플러그인을 적용해 코드 컨벤션을 유지합니다.

### 대용량 트래픽과 고가용성을 고려한 서버 구조 설계

- 단순히 기능 구현만을 하는것이 아닌, 현재 개발하는 서비스가 성장하여 대용량 트래픽을 견뎌야 할 상황을 고려 해 서버 구조를 설계하려 노력했습니다.

### 재사용과 유지보수에 용이한 구조를 설계하고 코드를 작성하려 합니다.

- Layered Architecture의 단점을 보완하기 위해 Hexagonal Architecture를 적용하여, 외부 환경의 변화에 애플리케이션 코드가 영향을 받지 않도록 구현하려 했습니다.

### 테스트의 중요성

- 테스트의 중요성을 깨닫기 위해,  프로젝트에서는 테스트 커버리지를 70% 이상을 유지하기 위해, Jacoco와 Github Action을 이용해, 테스트 커버리지가 70% 이상을 유지하지 못할 시, 해당 코드는 빌드 실패하도록 Github Action을 설정했습니다.
- 유닛 테스트 코드를 꼼꼼하게 작성함으로써, 서비스의 기능이 추가되고 수정됨에 따라 생길 수 있는 사이드 이펙트를 최소화 시키고자 
- 테스트 커버리지를 유지하고, 테스트 코드를 작성하면서 테스트에 대해 개인적인 생각을 정리한 블로그 입니다.[링크](https://simgee.tistory.com/45)

## 프로젝트 문서화

- 프로젝트를 진행하면서 작성한 부가적인 내용들을 위키에 정리하였습니다.
- 해당 [링크](https://github.com/f-lab-edu/Goods-For-You/wiki/%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8-%EA%B4%80%EB%A0%A8-%EC%BB%A8%EB%B2%A4%EC%85%98-&-Rule)를 참고해주세요😊

## 프로젝트를 진행하면서 발생한 이슈에 대한 고민과 해결 과정

- [서버 확장 전략 어떤걸 선택해야할까?](https://simgee.tistory.com/32)
- [다중 서버 환경에서 사용자 로그인 구현 시 세션 관리 방법으로 어떤걸 선택해야할까?](https://simgee.tistory.com/34)
- [인증 방식으로 세션 VS 토큰 어떤걸 선택해야 할까?](https://simgee.tistory.com/35)
- [GoodsForYou 패키지 구조에 대한 고민(포트와 어댑터)](https://simgee.tistory.com/41)
- [CAP 이론을 바탕으로 NoSQL 을 적용 할 만한 포인트 고려](https://simgee.tistory.com/42)
- [캐싱은 언제 적용하는게 좋을까?](https://simgee.tistory.com/43)

## Github Action을 통한 CI/CD

- Github Action을 통한 CI/CD를 구축함으로써, 자동으로 Push된 코드를 테스트 하고, 배포하는 과정을 구축했습니다

## 🛠사용 기술

- Java17
- SpringBoot 3
- Gradle
- Mysql
- Mybatis
- Redis
- Docker-Compose

## 프로젝트 화면 구성

- 카카오 오븐으로 구성한 화면 프로토 타입입니다 상세한 내용은 [Wiki](https://github.com/f-lab-edu/Goods-For-You/wiki/%ED%99%94%EB%A9%B4-%ED%94%84%EB%A1%9C%ED%86%A0-%ED%83%80%EC%9E%85)를 참고해주세요

![0105114308696542](https://user-images.githubusercontent.com/76669404/210689539-a5b3d9ea-cfbb-4e52-b17e-0c0a12c3f5f9.jpg)

## 유즈 케이스

- 프로젝트를 진행하면서 작성한 [유즈 케이스](https://github.com/f-lab-edu/Goods-For-You/wiki/%EC%9C%A0%EC%A6%88-%EC%BC%80%EC%9D%B4%EC%8A%A4) 입니다
