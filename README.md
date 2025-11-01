# java-lotto-precourse

## 구현 기능

- [x] 로또 구입 금액 입력 받기
- [x] 잘못된 값 입력시 재입력 받기
- [ ] 구입 금액에 맞는 로또 발행
- [ ] 당첨 번호 및 보너스 번호 입력 받기
- [ ] 로또 번호와 당첨 번호 비교 및 당첨 확인
- [ ] 당첨 내역 및 수익률 출력

---

## 예외 처리

- [x] 로또 구입 금액에 숫자가 아닌 문자가 입력되었을 때
- [x] 로또 구입 금액에 너무 큰 값이 입력되었을 때
- [x] 로또 구입 금액에 0 이하의 값이 입력되었을 때
- [x] 로또 구입 금액에 1000의 배수가 아닌 숫자가 입력되었을 때
- [ ] 당첨 번호의 개수가 다르게 입력되었을 때
- [ ] 당첨 번호에 범위를 벗어나는 숫자가 입력되었을 때
- [ ] 당첨 번호에 숫자가 아닌 문자가 입력되었을 때

---

## 전제 조건

- 8,145,060,000원이면 모든 숫자 종류의 로또를 구매 할 수 있으므로 그 이상의 값은 입력받지 않는다

---

## 클래스 설명

### [common]

- `ErrorMessage` : 에러 발생시 출력할 메세지들을 모아놓은 상수 클래스
- `ViewMessage` : 입출력시 사용할 메세지들을 모아놓은 상수 클래스


- `Strategy` : 프로그램의 규칙과 관련된 상수를 뫃아놓은 클래스

### [controller]

- `LottoController` : 로또 발행 프로그램을 관리하는 클래스

### [model]

- `LottoTickets` : 구매한 로또들을 모아놓은 일급 컬렉션 객체
- `LottoTicketsDTO` : `LottoTickets`의 데이터 전송 객체


- `Lotto` : 로또 객체
- `LottoDTO` : `Lotto`의 데이터 전송 객체
- `LottoGenerator` : 로또를 생성하는 객체의 인터페이스
- `LottoGeneratorImpl` : `LottoGenerator`를 구현한 객체
- `PurchaseAmount` : 로또 구매 금액 객체

### [service]

- `LottoBuyingServie` : 로또 구매 서비스를 담당하는 객체
- `LottoBuyingServieImpl` : `LottoBuyingService`를 구현한 객체

### [view]

- `LottoView` : 입출력을 담당하는 객체
- `InputView` : 입력을 담당하는 객체
- `OutputView` : 출력을 담당하는 객체

 `Application` : 프로그램을 실행하는 객체
