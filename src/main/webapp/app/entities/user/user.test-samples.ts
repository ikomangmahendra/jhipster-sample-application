import { IUser } from './user.model';

export const sampleWithRequiredData: IUser = {
  id: 14917,
  login: 'fvBlv@CY\\HLXt\\"AMLc',
};

export const sampleWithPartialData: IUser = {
  id: 32533,
  login: '}fZ~!@S\\,yM\\Rk\\K9WR1\\Ya',
};

export const sampleWithFullData: IUser = {
  id: 32388,
  login: 'K',
};
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
