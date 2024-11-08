import dayjs from 'dayjs/esm';

import { IConsumer, NewConsumer } from './consumer.model';

export const sampleWithRequiredData: IConsumer = {
  id: 27612,
  guid: 'validity even in',
  recordStatusId: 22466,
};

export const sampleWithPartialData: IConsumer = {
  id: 29510,
  guid: 'because',
  createdDate: dayjs('2024-11-07T21:58'),
  lastModifiedBy: 'hundred carefully urgently',
  lastModifiedDate: dayjs('2024-11-08T01:04'),
  recordStatusId: 2002,
};

export const sampleWithFullData: IConsumer = {
  id: 6352,
  guid: 'painfully',
  note: 'team which satisfy',
  createdBy: 'and custody between',
  createdDate: dayjs('2024-11-07T23:48'),
  lastModifiedBy: 'sticky across',
  lastModifiedDate: dayjs('2024-11-07T21:57'),
  recordStatusId: 5291,
};

export const sampleWithNewData: NewConsumer = {
  guid: 'uh-huh gum incidentally',
  recordStatusId: 2755,
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
