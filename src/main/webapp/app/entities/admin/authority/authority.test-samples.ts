import { IAuthority, NewAuthority } from './authority.model';

export const sampleWithRequiredData: IAuthority = {
  name: 'aba5bbae-627e-4236-bf53-b433a61f61d6',
};

export const sampleWithPartialData: IAuthority = {
  name: '327b3279-5bcf-47ca-a125-6c0bbb3b5587',
};

export const sampleWithFullData: IAuthority = {
  name: 'f7f37474-55ea-4b1b-a5c6-da835b09bbcd',
};

export const sampleWithNewData: NewAuthority = {
  name: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
