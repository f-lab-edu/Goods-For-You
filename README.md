# Goods-For-You

K-POP 스타뿐만 아니라 인플루언서 및 스포츠스타들의 굿즈 등을 간단하고 쉽게 판매 등록 및 구매,교환 할 수 있도록 구축한 플랫폼입니다.

## 🎯 프로젝트 목표

### 코드 컨벤션

- Naver Code Style을 적용해, 준수합니다
- Check Style 플러그인을 적용해 코드 컨벤션을 유지합니다.

### 대용량 트래픽을 고려한 서버 구조 설계
- 단순히 기능 구현만을 하는것이 아닌, 현재 개발하는 서비스가 성장하여 대용량 트래픽을 견뎌야 할 상황을 고려 해 서버 구조를 설계하려 노력했습니다.

## 기술적 이슈 정리

- 작성 예정
  
## 🔀 브랜치 관리 전략

- Git Flow를 사용해 브랜치를 관리합니다.
모든 브랜치는 Pull Request를 토대로 코드 리뷰를 진행한 후 merge를 진행합니다.

<img src="https://techblog.woowahan.com/wp-content/uploads/img/2017-10-30/git-flow_overall_graph.png" width="800px" height="800px" title="Github_Logo"/>

- `master` : 제품으로 출시 될 수 있는 테스트와 검증을 끝낸 브랜치를 의미합니다.
- `develop` : 제품의 다음 출시 버전을 개발하는 브랜치 입니다. `feature` 브랜치에서 리뷰 완료한 브랜치를 Merge하고 있는 브랜치입니다.
- `feature` : 제품 기능 개발을 위한 브랜치 입니다.
- `release` : 배포를 준비할 때 사용하는 브랜치 입니다.
- 'Hot-Fix` : 배포를 진행한 후 발생한 버그를 수정해야 할 때 사용하는 브랜치 입니다.

📝 참고 문헌 : [우아한 형제들 기술 블로그](https://techblog.woowahan.com/2553/)

## PR Rule

- 기능 개발은 `feature` 브랜치에서 진행하며, 브랜치명은 `feature/이슈번호-작업내용` 입니다.
- 모든 `PR`은 리뷰어에게 `코드 리뷰`를 받아야만 합니다.
- 리뷰어에게 `Approve`를 받아야 `Merge Pull Request`를 할 수 있습니다.

## Commit Rule

### 커밋 유형
- feat : 새로운 기능의 추가
- fix: 버그 수정
- docs: 문서 수정
- style: 스타일 관련 기능(코드 포맷팅, 세미콜론 누락, 코드 자체의 변경이 없는 경우)
- refactor: 코드 리펙토링
- test: 테스트 코트, 리펙토링 테스트 코드 추가
- chore: 빌드 업무 수정, 패키지 매니저 수정(ex .gitignore 수정 같은 경우)

### 커밋 작성 시 Rule

- 제목 행을 50자로 제한
- 제목 행 끝에 마침표를 넣지 않는다.
- 어떻게 보다는 무엇과 왜를 설명한다.

### 커밋 예시
- `[이슈 번호] feat : 커밋 제목 [PR 번호(PR이 존재할 시)]`


## 🛠사용 기술

- Java17
- SpringBoot
- Gradle
- Mysql

## 프로젝트 화면 구성

![0102222455410555](https://user-images.githubusercontent.com/76669404/210237397-b06a272c-782c-4bc0-b4fe-fba2b9398dbd.jpg)


