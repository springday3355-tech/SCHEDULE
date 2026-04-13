# 일정 관리 서버
- Spring boot와 JPA를 활용한 일정관리 API서버제작

## I. API 명세서

| 기능 | Method | URL | Request Body | Reponse Body | 상태코드 |
| :--- | :--- | :--- | :--- | :--- | :--- |
| 일정 생성 | POST | `/schedules` | `title`, `contents`, `name`, `password`| 생성된 일정 정보 | 201|
| 일정 단건 조회 | GET | `/schedules/{scheduleId}` | - | 일정 상세 정보 | 200 |
| 일정 전체 조회 | GET |`/schedules`| - | 일정 목록 | 200 |
| 일정 수정 | PATCH | `/schedules/{scheduleId}` | `title`, `name` | 수정된 일정 정보 | 200 |
| 일정 삭제 | DELETE | `/schedules/{scheduleId}`| `password` (JSON) | - | 204 |
 


## II. ERD
<img width="594" height="269" alt="image" src="https://github.com/user-attachments/assets/182424a8-e610-4a18-807b-e9e354170580" />
