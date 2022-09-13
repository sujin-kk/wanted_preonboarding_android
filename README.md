# wanted_preonboarding_android

## OverView
> 원티드 프리온보딩 안드로이드 사전과제
> 뉴스 앱 서비스

<img src="https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=Android&logoColor=white"> <img src="https://img.shields.io/badge/Kotlin-7F52FF?style=for-the-badge&logo=Kotlin&logoColor=white">

|![ezgif com-gif-maker (3)](https://user-images.githubusercontent.com/85485290/190000411-b1731427-223e-413b-bc97-6190e916f1df.gif)|![ezgif com-gif-maker (5)](https://user-images.githubusercontent.com/85485290/189999907-fded82a2-7802-4020-9ee0-e0874f1707f4.gif)|![ezgif com-gif-maker (2)](https://user-images.githubusercontent.com/85485290/189999346-dafd6908-bf65-4c56-abf9-d58e4df8b347.gif)
|:------:|:---:|:---:|
| **Top News** | **Category** | **Saved** |

## About

**Features**

- 1. 최신 뉴스 리스트 조회
- 2. 카테고리 선택
- 3. 카테고리별 뉴스 리스트 조회
- 4. 상세 뉴스 조회
- 5. 뉴스 저장 (북마크)
- 6. 저장된 뉴스 리스트 조회



**Technology Stack**
- Tools : Android Studio Bublebee
- Language : Kotlin
- Architecture Pattern : MVVM Pattern
- Android Architecture Components(AAC)
  - Flow
  - ViewModel
  - Coroutine
  - Data Binding
- Naivgation Conponponent
- HILT
- ROOM
- OKHTTP
- RETROFIT
- MOSHI
- SERIALIZATION
- GLIDE
- TIMBER 


**Foldering**
```
🔖
.
├── data
│   ├── api
│   ├── local
│   ├── mapper
│   └── remote
├── di
├── domain
│   ├── model
│   └── repository
├── presentation
│   ├── base
│   └── ui
└── util
```

## ToDo
- Jetpack Paging3를 활용한 Infinity Scroll 구현
- 네트워크 연결 여부 확인
