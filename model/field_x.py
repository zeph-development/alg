from abc import abstractmethod


class XYField:
    @abstractmethod
    def get_x(self) -> int: raise NotImplementedError

    @abstractmethod
    def set_x(self, x: int): raise NotImplementedError

    @abstractmethod
    def get_y(self) -> int: raise NotImplementedError

    @abstractmethod
    def set_y(self, y: int): raise NotImplementedError
