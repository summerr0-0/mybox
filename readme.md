# USECASE



| action                                   | 예측결과                                                  | 서버의 작업                                                  |
| ---------------------------------------- | --------------------------------------------------------- | ------------------------------------------------------------ |
| 유저가 가입을 한다                       | 유저의 루트 폴더가 생성된다.<br />유저는 30G용량을 받는다 | 유저 테이블에 추가된다<br /> 폴더에 root가 생성된다          |
| 유저가 리스트 조회를 한다                | 해당 경로의 폴더 / 파일을 확인할 수 있다                  | 요청이들어온 경로의 폴더와 파일 List를 보여준다<br />deleted된 파일들은 제외한다 |
| 유저가 루트에 A 폴더를 만든다            | 루트에 A폴더가 생성된다                                   | 폴더 테이블에 parentId가 해당 유저의 루트Id인 컬럼이 생성된다 |
| 유저가 A폴더에 파일을 추가한다           | A폴더에 파일이 추가된다                                   | userTable에 사용중인 용량 증가<br /> 파일 테이블에 folderId가 A인 행 추가<br />외부 저장소에 파일이 저장된다<br /> 그 경로가 file table에 저장된다 |
| 유저가 파일을 다운로드 한다              | 파일이 다운로드 된다                                      | 파일 테이블에                                                |
| 유저가 A폴더 내부에 B폴더 추가           |                                                           |                                                              |
| 유저가 B폴더에 파일 추가                 |                                                           |                                                              |
| 유저가 루트를 다운로드함                 | zip파일로 압축되어 저장된다                               | 루트가 parent인 폴더들 검색<br /> 폴더 depth 없을때까지 탐색<br /> 폴더들에 해당하는 파일들 전부 저장..<br /> 저장할 때 zip으로 묶는건 어케하지 |
| 유저가 용량이 다 찼는데 파일 업로드 시도 |                                                           |                                                              |
| 유저가 파일을 삭제함                     |                                                           |                                                              |
|                                          |                                                           |                                                              |

# 이벤트 정리

- 유저 생성 이벤트

- 파일 업로드 이벤트

- 파일 삭제 이벤트

- 폴더 생성 이벤트

- 폴더 삭제 이벤트

  | 이벤트             | 발생                                               |      |
  | :----------------- | -------------------------------------------------- | ---- |
  | UserJoinedEvent    | UserCreateHandler<br />RootCreateHandler           |      |
  | FileUploadedEvent  | UsedStorageIncreaseHandler<br />FileUploadHandler  |      |
  | FileDeletedEvent   | UsedStorageDecreaseHandler<br /> FileDeleteHandler |      |
  | FolderCreatedEvent | FolderCreateHandler                                |      |
  | FolderDeletedEvent | FolderDeleteHandler+                               |      |

  

# 구조




- 커맨드 분리
  - c : jpa
  - q : 

- 유저 API

  유저 생성(필수 기능은 아닙니다. 여의치 않을 경우 DB 에 dummy data 로 만들어도 됩니다.)

  유저 정보 조회(userId, 사용량 등)

- 파일 API

  업로드

  다운로드

  삭제

- 폴더 API

  생성

  삭제

  자식 파일/폴더 리스트 조회

  다운로드(옵션)